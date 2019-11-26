package build;

public class Controller
{
    Model model;
    ClientView view;

    public Controller(Model m)
    {
        this.model = m;
        view = new ClientView(this);
    }

    public static void main(String[] args)
    {
        Model m = new Model();
        Controller c = new Controller(m);
    }
}
