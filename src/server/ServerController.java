package server;

public class ServerController
{
    protected ServerModel model;
    protected ServerView view;

    public ServerController(ServerModel model)
    {
        this.model = model;
        this.model.setController(this);
    }

    public void clientAttack()
    {

    }

    public void serverAttack()
    {

    }

    public void windowIsClosing()
    {
        model.stopListening();
    }

    public void startListening()
    {
        model.startListening();
    }

    public void stopListening()
    {
        model.stopListening();
    }
}
