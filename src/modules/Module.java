package modules;

/**
 * Created by apryakhin on 28.10.2015.
 */
public abstract class Module implements ModuleInterface {
    protected boolean isLicensed = false;
    protected String myLicenseKey;

    public boolean checkLicense(){
        return true;
    }
}
