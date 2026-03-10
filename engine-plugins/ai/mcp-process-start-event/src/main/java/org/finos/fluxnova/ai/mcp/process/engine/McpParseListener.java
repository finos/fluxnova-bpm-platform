package org.finos.fluxnova.ai.mcp.process.engine;

import org.finos.fluxnova.ai.mcp.process.model.ToolDefinition;
import org.finos.fluxnova.bpm.engine.impl.bpmn.parser.AbstractBpmnParseListener;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.finos.fluxnova.bpm.engine.impl.pvm.process.ActivityImpl;
import org.finos.fluxnova.bpm.engine.impl.pvm.process.ScopeImpl;
import org.finos.fluxnova.bpm.engine.impl.util.xml.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * BPMN parse listener that intercepts start event parsing to extract and register MCP tool definitions.
 * <p>
 * This listener is registered with the Fluxnova process engine during deployment parsing. When a BPMN
 * process definition is deployed, this listener examines each start event for MCP-specific extension
 * elements (toolName, description, parameters). If found, it creates and registers an MCP tool that
 * can be invoked by MCP clients to start a new process instance.
 * </p>
 * <p>
 * The listener delegates to:
 * <ul>
 *   <li>{@link BpmnStartEventToolExtractor} - to extract MCP metadata from BPMN XML</li>
 *   <li>{@link ToolFactory} - to create and register the tool with the {@code ToolRegistry}</li>
 * </ul>
 * </p>
 * <p>
 * <strong>Lifecycle:</strong> This listener is invoked during BPMN deployment, before the process
 * definition is activated. Tools are registered immediately and become available to MCP clients.
 * </p> *
 */
public class McpParseListener extends AbstractBpmnParseListener {
    private static final Logger LOG = LoggerFactory.getLogger(McpParseListener.class);

    private final BpmnStartEventToolExtractor extractor;
    private final ToolFactory factory;

    public McpParseListener(BpmnStartEventToolExtractor extractor, ToolFactory factory) {
        this.extractor = extractor;
        this.factory = factory;
        LOG.debug("MCP - McpParseListener instance created: {}", this);
    }

    @Override
    public void parseStartEvent(Element startEventElement, ScopeImpl scope, ActivityImpl activity) {
        try {
            String processId = ((ProcessDefinitionEntity) scope.getProcessDefinition()).getKey();
            String startEventId = activity.getId();

            LOG.debug("MCP - Parsing start event '{}' in process '{}'", startEventId, processId);

            ToolDefinition definition = extractor.extract(startEventElement, processId);

            if (definition != null) {
                LOG.info("MCP - Found MCP tool definition, registering: '{}'", definition.toolName());
                factory.createAndRegister(definition);
            } else {
                LOG.debug("MCP - No MCP tool definition found for start event '{}' in process '{}'",
                        startEventId, processId);
            }

        } catch (Exception e) {
            LOG.error("MCP - Error processing MCP start event in process: {}",
                    ((ProcessDefinitionEntity) scope.getProcessDefinition()).getKey(), e);
        }
    }
}
