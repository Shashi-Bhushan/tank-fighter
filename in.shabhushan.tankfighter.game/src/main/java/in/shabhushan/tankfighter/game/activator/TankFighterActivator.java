package in.shabhushan.tankfighter.game.activator;

import in.shabhushan.tankfighter.game.service.CircleGameService;
import in.shabhushan.tankfighter.game.service.internal.CircleGameServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.Hashtable;

import static java.lang.System.out;

/**
 * Extension of default OSGi bundle Activator
 *
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class TankFighterActivator implements BundleActivator {

    /**
     * Called when OSGi framework starts our bundle
     * @param bundleContext
     * @throws Exception
     */
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        out.println("Starting " + this.getClass().getName() + "#start");

        Hashtable properties = new Hashtable();
        properties.put("osgi.command.scope", "circle");
        properties.put("osgi.command.function", new String[]{"startGame", "stopGame"});

        bundleContext.registerService(CircleGameService.class.getName(), new CircleGameServiceImpl(), properties);
    }

    /**
     * Called when OSGi stops our bundle
     * @param bundleContext
     * @throws Exception
     */
    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        out.println("Stopping " + this.getClass().getName() + "#start");

    }
}
