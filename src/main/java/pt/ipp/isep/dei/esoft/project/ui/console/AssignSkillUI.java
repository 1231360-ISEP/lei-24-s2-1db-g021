package pt.ipp.isep.dei.esoft.project.ui.console;

import jdk.jshell.execution.Util;
import pt.ipp.isep.dei.esoft.project.application.controller.AssignSkillController;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AssignSkillUI implements Runnable{
    private AssignSkillController controller;

    public AssignSkillUI() {
        this.controller = new AssignSkillController();
    }

    public AssignSkillController getController() {
        return controller;
    }

    private List<Skill> getSkillsSelected(List<Skill> skills){
        List<Skill> skillsSelected = new ArrayList<>();
        int skillIndexSelected = 0;
        while (true){
            skillIndexSelected = Utils.readIntegerFromConsole("Select one Skill: ") - 1;
            if (skillIndexSelected != -1){
                skillsSelected.add(skills.get(skillIndexSelected));
            }
            else
                break;
        }
        return skillsSelected;
    }
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        List<Collaborator> collaboratorList = controller.getCollaborators();
        Utils.showList(collaboratorList, "Collaborators");
        int collaboratorIndex = Utils.readIntegerFromConsole("Select the collaborator: ") - 1;
        if (collaboratorIndex == -1)
            return;
        controller.setCollaboratorSelected(collaboratorList.get(collaboratorIndex));
        List<Skill> skills = controller.getSkills();
        Utils.showList(skills, "Skills");
        controller.storeSkills(getSkillsSelected(skills));
        int confirm = -1;
        while (confirm < 0 || confirm > 1){
            confirm = Utils.readIntegerFromConsole("Press 1 to confirm and 0 to discard changes: ");
        }
        if (confirm == 1)
            controller.addSkills();
    }
}
