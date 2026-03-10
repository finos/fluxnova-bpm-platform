package org.finos.fluxnova.ai.mcp.process.engine;

import org.finos.fluxnova.bpm.engine.RepositoryService;
import org.finos.fluxnova.bpm.engine.repository.ProcessDefinition;
import org.finos.fluxnova.bpm.engine.repository.ProcessDefinitionQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class McpStartupScannerTest {

    private RepositoryService repositoryService;
    private BpmnStartEventToolExtractor extractor;
    private ToolFactory factory;
    private McpStartupScanner scanner;

    @BeforeEach
    void setUp() {
        repositoryService = mock(RepositoryService.class);
        extractor = mock(BpmnStartEventToolExtractor.class);
        factory = mock(ToolFactory.class);
        scanner = new McpStartupScanner(repositoryService, extractor, factory);
    }

    @Test
    void shouldQueryLatestProcessDefinitions() {
        ProcessDefinitionQuery query = mock(ProcessDefinitionQuery.class);
        when(repositoryService.createProcessDefinitionQuery()).thenReturn(query);
        when(query.latestVersion()).thenReturn(query);
        when(query.list()).thenReturn(Collections.emptyList());

        scanner.scanAndRegisterExistingProcesses();

        verify(repositoryService).createProcessDefinitionQuery();
        verify(query).latestVersion();
        verify(query).list();
    }

    @Test
    void shouldLoadProcessModelForEachDefinition() {
        ProcessDefinition processDefinition = mock(ProcessDefinition.class);
        when(processDefinition.getId()).thenReturn("process-def-1");
        when(processDefinition.getKey()).thenReturn("testProcess");

        ProcessDefinitionQuery query = mock(ProcessDefinitionQuery.class);
        when(repositoryService.createProcessDefinitionQuery()).thenReturn(query);
        when(query.latestVersion()).thenReturn(query);
        when(query.list()).thenReturn(List.of(processDefinition));

        String bpmnXml = """
            <?xml version="1.0" encoding="UTF-8"?>
            <definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL">
              <process id="testProcess">
                <startEvent id="start"/>
              </process>
            </definitions>
            """;

        InputStream bpmnStream = new ByteArrayInputStream(bpmnXml.getBytes());
        when(repositoryService.getProcessModel("process-def-1")).thenReturn(bpmnStream);

        scanner.scanAndRegisterExistingProcesses();

        verify(repositoryService).getProcessModel("process-def-1");
    }

    @Test
    void shouldHandleEmptyProcessDefinitionList() {
        ProcessDefinitionQuery query = mock(ProcessDefinitionQuery.class);
        when(repositoryService.createProcessDefinitionQuery()).thenReturn(query);
        when(query.latestVersion()).thenReturn(query);
        when(query.list()).thenReturn(Collections.emptyList());

        scanner.scanAndRegisterExistingProcesses();

        verify(repositoryService).createProcessDefinitionQuery();
        verifyNoInteractions(factory);
    }

    @Test
    void shouldNotFailWhenProcessModelCannotBeLoaded() {
        ProcessDefinition processDefinition = mock(ProcessDefinition.class);
        when(processDefinition.getId()).thenReturn("failing-process");
        when(processDefinition.getKey()).thenReturn("failingProcess");

        ProcessDefinitionQuery query = mock(ProcessDefinitionQuery.class);
        when(repositoryService.createProcessDefinitionQuery()).thenReturn(query);
        when(query.latestVersion()).thenReturn(query);
        when(query.list()).thenReturn(List.of(processDefinition));

        when(repositoryService.getProcessModel("failing-process"))
                .thenThrow(new RuntimeException("Failed to load BPMN"));

        // should not throw exception
        scanner.scanAndRegisterExistingProcesses();

        verify(repositoryService).getProcessModel("failing-process");
    }

    @Test
    void shouldProcessMultipleDefinitions() {
        ProcessDefinition def1 = mock(ProcessDefinition.class);
        when(def1.getId()).thenReturn("process-1");
        when(def1.getKey()).thenReturn("process1");

        ProcessDefinition def2 = mock(ProcessDefinition.class);
        when(def2.getId()).thenReturn("process-2");
        when(def2.getKey()).thenReturn("process2");

        ProcessDefinitionQuery query = mock(ProcessDefinitionQuery.class);
        when(repositoryService.createProcessDefinitionQuery()).thenReturn(query);
        when(query.latestVersion()).thenReturn(query);
        when(query.list()).thenReturn(List.of(def1, def2));

        String bpmnXml = """
            <?xml version="1.0" encoding="UTF-8"?>
            <definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL">
              <process id="test"><startEvent id="start"/></process>
            </definitions>
            """;

        when(repositoryService.getProcessModel("process-1"))
                .thenReturn(new ByteArrayInputStream(bpmnXml.getBytes()));
        when(repositoryService.getProcessModel("process-2"))
                .thenReturn(new ByteArrayInputStream(bpmnXml.getBytes()));

        scanner.scanAndRegisterExistingProcesses();

        verify(repositoryService).getProcessModel("process-1");
        verify(repositoryService).getProcessModel("process-2");
    }
}
