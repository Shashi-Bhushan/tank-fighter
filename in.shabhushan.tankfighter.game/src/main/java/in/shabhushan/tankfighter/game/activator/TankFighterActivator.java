package in.shabhushan.tankfighter.game.activator;

import in.shabhushan.tankfighter.game.service.CircleGameService;
import in.shabhushan.tankfighter.game.service.TankGameService;
import in.shabhushan.tankfighter.game.service.internal.CircleGameServiceImpl;
import in.shabhushan.tankfighter.game.service.internal.TankGameServiceImpl;
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

        Hashtable circleProperties = new Hashtable();
        circleProperties.put("osgi.command.scope", "circle");
        circleProperties.put("osgi.command.function", new String[]{"startGame", "stopGame"});

        bundleContext.registerService(CircleGameService.class.getName(), new CircleGameServiceImpl(), circleProperties);

        Hashtable tankProperties = new Hashtable();
        tankProperties.put("osgi.command.scope", "tank");
        tankProperties.put("osgi.command.function", new String[]{"startGame", "stopGame"});

        bundleContext.registerService(TankGameService.class.getName(), new TankGameServiceImpl(), tankProperties);
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
