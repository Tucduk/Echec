public class ControlGroup {
    Model model;
    Vue vue;

    public ControlGroup(Model model){
        this.model = model;
        vue = new Vue(model);
    }
}
