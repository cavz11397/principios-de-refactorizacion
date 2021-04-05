package co.com.sofka.app;

/**
 * Reloader for a "live" project, where project data is expected to change
 * frequently.  Periodic reloads are necessary for time of last update, 
 * project details, and login statistics.
 * 
 */
public class LiveProjectDataReloader extends ProjectDataReloader {

    protected LiveProjectDataReloader(Project project) {
        super(project);
    }

    @Override
    protected void reloadProjectData() {
        // load details every other reload attempt
        if (modulo(reloadsCounter,2,0)) {
            load(1L);
        }
        //do this often
        load(2L);
        
        // don't need this very often..
        // load login statistics every five hundred reload attempts
        if (modulo(reloadsCounter,500,0)) {
            load(3L);
        }
    }

    public void load(final Long i){
        new Thread(new Runnable() {

            @Override
            public void run() {
                if(equalsNumber(i,1L)){
                    loadProjectDetails();
                }else if(equalsNumber(i,2L)){
                    loadLastUpdateTime();
                }else{
                    loadLoginStatistics();
                }

            }
        }).start();
    }

}
