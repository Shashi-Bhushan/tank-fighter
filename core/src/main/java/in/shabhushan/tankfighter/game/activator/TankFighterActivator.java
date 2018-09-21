package in.shabhushan.tankfighter.game.activator;

import in.shabhushan.tankfighter.game.model.Tank;
import in.shabhushan.tankfighter.game.service.TankGameService;
import in.shabhushan.tankfighter.game.service.internal.TankGameServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Hashtable;

import static java.lang.System.out;

/**
 * Extension of default OSGi bundle Activator
 *
 * @author Shashi Bhushan
 * @date 17/9/18
 */
public class TankFighterActivator implements BundleActivator {

    private static final Logger LOG = LoggerFactory.getLogger(TankFighterActivator.class);

    /**
     * Called when OSGi framework starts our bundle
     * @param bundleContext
     * @throws Exception
     */
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        out.println("Starting " + this.getClass().getName() + "#start");
        LOG.info("Starting {} #start", this.getClass().getName());

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
        out.println("Stopping " + this.getClass().getName() + "#stop");
        LOG.info("Stopping {} #stop", this.getClass().getName());
    }
}
