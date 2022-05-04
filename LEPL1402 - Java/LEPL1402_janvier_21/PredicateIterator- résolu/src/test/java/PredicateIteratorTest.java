import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class PredicateIteratorTest {

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(0,1,2,4,5,6,7);
        Iterator<Integer> ite = new PredicateIterator<>(list.iterator(),i -> i%2 == 0);
        Assert.assertTrue(ite.hasNext());
        Assert.assertTrue(ite.hasNext());
        int a = ite.next();
        Assert.assertTrue(0 == a);
        Assert.assertTrue(2 == ite.next());

        Assert.assertTrue(ite.hasNext());
        Assert.assertTrue(ite.hasNext());
        Assert.assertTrue(4 == ite.next());

        Assert.assertTrue(ite.hasNext());
        Assert.assertTrue(6 == ite.next());

        Assert.assertTrue(!ite.hasNext());
        Assert.assertTrue(!ite.hasNext());

    }

    @Test
    public void test2() {

        List<Integer> list = Arrays.asList(0,1,2,4,5,6,7);
        Iterator<Integer> ite = new PredicateIterator<>(list.iterator(),i -> i%3 == 0);

        Assert.assertTrue(ite.hasNext());

        Assert.assertTrue(0 == ite.next());

        Assert.assertTrue(ite.hasNext());

        Assert.assertTrue(6 == ite.next());


        Assert.assertTrue(!ite.hasNext());

    }

}
