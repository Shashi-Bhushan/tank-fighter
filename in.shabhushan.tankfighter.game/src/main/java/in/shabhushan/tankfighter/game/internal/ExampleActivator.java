package in.shabhushan.tankfighter.game.internal;

import java.util.Dictionary;
import java.util.Properties;

import in.shabhushan.tankfighter.game.engine.GameEngine;
import in.shabhushan.tankfighter.game.game.CircleGame;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import in.shabhushan.tankfighter.game.ExampleService;

import javax.swing.*;

/**
 * Extension of the default OSGi bundle activator
 */
public final class ExampleActivator
    implements BundleActivator
{

    private GameEngine game;

    /**
     * Called whenever the OSGi framework starts our bundle
     */
    public void start( BundleContext bc )
        throws Exception
    {
        System.out.println( "STARTING in.shabhushan.tankfighter.game" );

        Dictionary props = new Properties();
        // add specific service properties here...

        System.out.println( "REGISTER in.shabhushan.tankfighter.game.ExampleService" );

        // Register our example service implementation in the OSGi service registry
        bc.registerService( ExampleService.class.getName(), new ExampleServiceImpl(), props );

        JFrame frame = new JFrame();
        game = new CircleGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        game.start();
    }

    /**
     * Called whenever the OSGi framework stops our bundle
     */
    public void stop( BundleContext bc )
        throws Exception
    {
        game.stop();
        System.out.println( "STOPPING in.shabhushan.tankfighter.game" );

        // no need to unregister our service - the OSGi framework handles it for us
    }
}

