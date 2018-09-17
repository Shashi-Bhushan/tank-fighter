package in.shabhushan.tankfighter.game.activator;

import in.shabhushan.tankfighter.game.service.CircleGameService;
import in.shabhushan.tankfighter.game.service.internal.CircleGameServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;

import static java.lang.System.out;

/**
 * Extension of default
 *
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class TankFighterActivator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        out.println("Starting " + this.getClass().getName() + "#start");

        Hashtable properties = new Hashtable();
        properties.put("osgi.command.scope", "tank");
        properties.put("osgi.command.function", "showCircle");

        bundleContext.registerService(CircleGameService.class.getName(), new CircleGameServiceImpl(), properties);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        out.println("Stopping " + this.getClass().getName() + "#start");

    }
}
