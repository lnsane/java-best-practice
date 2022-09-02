package com.best.spring.boot.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    private final TaskService taskService;

    private final HistoryService historyService;
    public TaskController(TaskService taskService, HistoryService historyService) {
        this.taskService = taskService;
        this.historyService = historyService;
    }

    @GetMapping(path = "histdd")
    public void findTask() {
        List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery()
                .orderByProcessInstanceId()
                .asc()
                .list();
        if (list != null && list.size() > 0) {
            for (HistoricProcessInstance hpi : list) {
                System.out.println("流程定义ID：" + hpi.getProcessDefinitionId());
                System.out.println("流程实例ID：" + hpi.getId());
                System.out.println("开始时间：" + hpi.getStartTime());
                System.out.println("结束时间：" + hpi.getEndTime());
                System.out.println("流程持续时间：" + hpi.getDurationInMillis());
                System.out.println("=======================================");
            }
        }
    }

    @GetMapping(path = "hist")
    public void queryHistoricActivitiInstance(@RequestParam("id") String id) {
        List<HistoricActivityInstance> list = historyService
                .createHistoricActivityInstanceQuery()
                .processInstanceId(id)
                .list();
        if (list != null && list.size() > 0) {
            for (HistoricActivityInstance hai : list) {
                System.out.println(hai.getId());
                System.out.println("步骤ID：" + hai.getActivityId());
                System.out.println("步骤名称：" + hai.getActivityName());
                System.out.println("执行人：" + hai.getAssignee());
                System.out.println("====================================");
            }
        }
    }
    @GetMapping(path = "histsss")
    public void queryHistoricActivitiIssnstance(@RequestParam("id") String id) {
        List<HistoricTaskInstance> list = historyService
                .createHistoricTaskInstanceQuery()
                .processInstanceId(id)
                .list();
        if (list != null && list.size() > 0) {
            for (HistoricTaskInstance hti : list) {
                System.out.print("taskId:" + hti.getId()+"，");
                System.out.print("name:" + hti.getName()+"，");
                System.out.print("pdId:" + hti.getProcessDefinitionId()+"，");
                System.out.print("assignee:" + hti.getAssignee()+"，");
            }
        }
    }


    @PostMapping(path = "findTaskByAssignee")
    public RestMessgae findTaskByAssignee(@RequestParam("assignee") String assignee) {
        RestMessgae restMessgae = new RestMessgae();

        //创建任务查询对象
        List<Task> taskList;
        try {
            taskList = taskService.createTaskQuery().active().list();
        } catch (Exception e) {
            restMessgae = RestMessgae.fail("查询失败", e.getMessage());
            e.printStackTrace();
            return restMessgae;
        }

        if (taskList != null && taskList.size() > 0) {
            List<Map<String, String>> resultList = new ArrayList<>();
            for (Task task : taskList) {
                Map<String, String> resultMap = new HashMap<>(7);
                /* 任务ID */
                resultMap.put("taskID", task.getId());

                /* 任务名称 */
                resultMap.put("taskName", task.getName());

                /* 任务的创建时间 */
                resultMap.put("taskCreateTime", task.getCreateTime().toString());

                /* 任务的办理人 */
                resultMap.put("taskAssignee", task.getAssignee());

                /* 流程实例ID */
                resultMap.put("processInstanceId", task.getProcessInstanceId());

                /* 执行对象ID */
                resultMap.put("executionId", task.getExecutionId());

                /* 流程定义ID */
                resultMap.put("processDefinitionId", task.getProcessDefinitionId());
                resultList.add(resultMap);
            }
            restMessgae = RestMessgae.success("查询成功", resultList);
        } else {
            restMessgae = RestMessgae.success("查询成功", null);
        }

        return restMessgae;
    }

    @PostMapping(path = "completeTask")
    public RestMessgae completeTask(@RequestParam("taskId") String taskId,
                                    @RequestParam("days") int days) {

        RestMessgae restMessgae = new RestMessgae();

        try {
            HashMap<String, Object> variables = new HashMap<>(1);
            variables.put("days", days);
            taskService.complete(taskId, variables);
        } catch (Exception e) {
            restMessgae = RestMessgae.fail("提交失败", e.getMessage());
            e.printStackTrace();
            return restMessgae;
        }
        restMessgae = RestMessgae.fail("提交成功", taskId);
        return restMessgae;
    }
}
