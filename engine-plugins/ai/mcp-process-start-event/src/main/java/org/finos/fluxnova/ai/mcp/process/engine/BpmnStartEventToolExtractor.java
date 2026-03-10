package org.finos.fluxnova.ai.mcp.process.engine;

import org.finos.fluxnova.ai.mcp.process.model.ToolDefinition;
import org.finos.fluxnova.ai.mcp.process.model.ToolParameter;
import org.finos.fluxnova.bpm.engine.impl.util.xml.Element;
import org.finos.fluxnova.bpm.engine.impl.util.xml.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Extracts MCP tool definitions from BPMN start event elements.
 * Reads the mcp:* attributes and child elements to build a ToolDefinition.
 */
public class BpmnStartEventToolExtractor {
    private static final Logger LOG = LoggerFactory.getLogger(BpmnStartEventToolExtractor.class);
    private static final Namespace MCP_NAMESPACE = new Namespace("http://fluxnova.finos.org/schema/1.0/ai/mcp", "mcp");

    /**
     * Extracts a tool definition from a BPMN start event element.
     *
     * @param startEvent the start event XML element
     * @param processId the process definition ID
     * @return ToolDefinition if MCP attributes are present, null otherwise
     */
    public ToolDefinition extract(Element startEvent, String processId) {
        try {
            String toolName = startEvent.attributeNS(MCP_NAMESPACE, "toolName");

            // If no tool name, this is not an MCP tool
            if (toolName == null || toolName.isBlank()) {
                return null;
            }

            String description = startEvent.attributeNS(MCP_NAMESPACE, "description");
            String propagateKeyStr = startEvent.attributeNS(MCP_NAMESPACE, "propagateBusinessKey");

            List<ToolParameter> parameters = extractParameters(startEvent);
            boolean propagateBusinessKey = propagateKeyStr == null || Boolean.parseBoolean(propagateKeyStr);
            if (propagateBusinessKey) {
                parameters.add(new ToolParameter("businessKey", "String", true));
            }

            ToolDefinition definition = new ToolDefinition(
                    processId,
                    toolName,
                    description != null ? description : "",
                    parameters,
                    propagateBusinessKey);

            LOG.debug("MCP - Extracted tool definition: {} for process: {}", toolName, processId);
            return definition;

        } catch (Exception e) {
            LOG.error("MCP - Failed to extract tool definition from start event in process: {}", processId, e);
            return null;
        }
    }

    /**
     * Extracts parameter definitions from the start event's extensionElements.
     */
    private List<ToolParameter> extractParameters(Element startEvent) {
        List<ToolParameter> parameters = new ArrayList<>();

        Element extensionElements = startEvent.element("extensionElements");
        if (extensionElements == null) {
            LOG.debug("MCP - No extensionElements found");
            return parameters;
        }

        Element parametersElement = extensionElements.elementNS(MCP_NAMESPACE, "parameters");
        if (parametersElement == null) {
            LOG.debug("MCP - No mcp:parameters element found");
            return parameters;
        }

        List<Element> paramElements = parametersElement.elementsNS(MCP_NAMESPACE, "parameter");
        LOG.debug("MCP - Found {} parameter elements", paramElements.size());

        for (Element paramElement : paramElements) {
            String name = paramElement.attribute("paramName");
            String type = paramElement.attribute("paramType");

            LOG.debug("MCP - Extracting parameter: name='{}', type='{}'", name, type);

            if (name != null && !name.isBlank() && type != null && !type.isBlank()) {
                parameters.add(new ToolParameter(name, type, false));
                LOG.debug("MCP - Added parameter: name='{}', type='{}'", name, type);
            } else {
                LOG.warn("MCP - Skipping invalid parameter with name='{}' type='{}'", name, type);
            }
        }

        LOG.debug("MCP - Total parameters extracted: {}", parameters.size());
        return parameters;
    }
}
