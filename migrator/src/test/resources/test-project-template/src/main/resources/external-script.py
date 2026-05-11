# External Python script for Camunda BPMN process
from org.camunda.bpm.engine import ProcessEngine, ProcessEngines
from org.camunda.bpm.engine.delegate import DelegateExecution, JavaDelegate
from org.camunda.bpm.engine.variable import Variables
from org.camunda.spin import Spin
from org.camunda.bpm.engine.impl.context import Context

# Custom imports with nested camunda
from org.camunda.example.camunda.sample import CustomDelegate
from org.camunda.bpm.camunda.service import ProcessService

class MyPythonDelegate(JavaDelegate):
    """Python delegate for process execution"""
    
    def execute(self, execution):
        # Get process engine
        process_engine = org.camunda.bpm.engine.ProcessEngines.getDefaultProcessEngine()
        runtime_service = process_engine.getRuntimeService()
        
        # Create variables
        variables = org.camunda.bpm.engine.variable.Variables.createVariables()
        variables.putValue("status", "active")
        
        # Use Spin for JSON
        json_data = org.camunda.spin.Spin.JSON('{"key": "value"}')
        
        # Custom service
        custom_service = org.camunda.example.camunda.sample.CustomCamundaDelegate()
        process_service = org.camunda.bpm.camunda.service.ProcessService()
        
        # Set result
        execution.setVariable("result", "python_processed")
        execution.setVariable("engine_name", org.camunda.bpm.engine.ProcessEngines.NAME_DEFAULT)

# Standalone execution
if __name__ == "__main__":
    engine = org.camunda.bpm.engine.ProcessEngines.getDefaultProcessEngine()
    print("Process engine initialized: " + str(engine))
