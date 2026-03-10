package org.finos.fluxnova.ai.mcp.process.engine;

import org.finos.fluxnova.ai.mcp.process.model.ToolDefinition;
import org.finos.fluxnova.bpm.engine.RepositoryService;
import org.finos.fluxnova.bpm.engine.impl.util.xml.Element;
import org.finos.fluxnova.bpm.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.List;

/**
 * Scans existing deployed process definitions at application startup to register MCP tools.
 * <p>
 * This scanner complements {@link McpParseListener} by handling processes that were already
 * deployed before the MCP plugin was activated. While {@code McpParseListener} registers tools
 * during new deployments, this scanner ensures that existing processes are also exposed as
 * MCP tools.
 * </p>
 * <p>
 * The scanner:
 * <ul>
 *   <li>Queries the repository for all latest-version process definitions</li>
 *   <li>Retrieves and parses the BPMN XML for each process</li>
 *   <li>Extracts MCP tool metadata from start events</li>
 *   <li>Registers discovered tools with the {@code ToolRegistry}</li>
 * </ul>
 * </p>
 * <p>
 * <strong>Lifecycle:</strong> This scanner is typically invoked once during application startup,
 * after the process engine has initialized but before the application accepts requests.
 * </p>
 * <p>
 * <strong>Error Handling:</strong> Failures to scan individual processes are logged but do not
 * prevent the scanner from continuing with remaining processes. This ensures partial failures
 * don't block application startup.
 * </p>
 */
public class McpStartupScanner {
    private static final Logger LOG = LoggerFactory.getLogger(McpStartupScanner.class);

    private final RepositoryService repositoryService;
    private final BpmnStartEventToolExtractor extractor;
    private final ToolFactory factory;

    public McpStartupScanner(RepositoryService repositoryService,
                             BpmnStartEventToolExtractor extractor,
                             ToolFactory factory) {
        this.repositoryService = repositoryService;
        this.extractor = extractor;
        this.factory = factory;
    }

    public void scanAndRegisterExistingProcesses() {
        LOG.info("MCP - Scanning existing process definitions for MCP tools");

        List<ProcessDefinition> definitions = repositoryService
                .createProcessDefinitionQuery()
                .latestVersion()
                .list();

        int registered = 0;
        for (ProcessDefinition definition : definitions) {
            try {
                registered += scanProcessDefinition(definition);
            } catch (Exception e) {
                LOG.error("MCP - Failed to scan process: {}", definition.getKey(), e);
            }
        }

        LOG.info("MCP - Startup scan complete. Registered {} tools from {} processes",
                registered, definitions.size());
    }

    private int scanProcessDefinition(ProcessDefinition definition) {
        try (InputStream bpmnStream = repositoryService.getProcessModel(definition.getId())) {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            docFactory.setNamespaceAware(true);
            Document doc = docFactory.newDocumentBuilder().parse(bpmnStream);

            NodeList startEvents = doc.getElementsByTagName("startEvent");
            int count = 0;

            for (int i = 0; i < startEvents.getLength(); i++) {
                Element startEvent = (Element) startEvents.item(i);
                ToolDefinition toolDef = extractor.extract(startEvent, definition.getKey());

                if (toolDef != null) {
                    factory.createAndRegister(toolDef);
                    count++;
                }
            }

            return count;
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse BPMN for process: " + definition.getKey(), e);
        }
    }
}
