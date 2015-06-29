package ut.com.jumlabs.test;

import org.junit.Test;
import com.jumlabs.test.MyPluginComponent;
import com.jumlabs.test.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}