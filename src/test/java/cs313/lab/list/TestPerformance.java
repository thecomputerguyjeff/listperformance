package cs313.lab.list;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestPerformance {

  // TODO run test and record running times for DRY = 10, 100, 1000, 10000, ...
  // (choose in conjunction with REPS below up to an upper limit where the clock
  // running time is in the tens of seconds)

  // TODO (optional) refactor to DRY
  // TODO answer: which of the two lists performs better as the size increases?
  private final int DRY = 100000;

  // TODO choose this value in such a way that you can observe an actual effect
  // for increasing problem sizes
  private final int REPS = 100000000;

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<Integer>(DRY);
    linkedList = new LinkedList<Integer>();
    for (int i = 0; i < DRY; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  @Test
  public void testLinkedListAddRemove() {
    for (int r = 0; r < REPS; r++) {
      linkedList.add(0, 77);
      linkedList.remove(0);
    }
    //when DRY = 10, 5s 485 ms
    //when DRY = 100, 5s 692ms
    //when DRY = 1000, 5s 658ms
    //when DRY = 100000, 4s 606ms
  }

  @Test
  public void testArrayListAddRemove() {
    for (int r = 0; r < REPS; r++) {
      arrayList.add(0, 77);
      arrayList.remove(0);
    }
    //when DRY = 10, 6 sec 693 ms
    //when DRY = 100, 9 sec 927ms
    //when DRY = 1000, 38 sec 48ms
    //when DRY = 100000,
  }

  @Test
  public void testLinkedListAccess() {
    long sum = 0;
    for (int r = 0; r < REPS; r++) {
      sum += linkedList.get(r % DRY);
    }
    //when DRY = 10, 1 sec 201 ms
    //when DRY = 100, 3 sec 313ms
    //when DRY = 1000, 35s 819ms
    //when DRY = 100000, very long - this morning computer said 16hr 21m 56s but could be slowed down because I wasn't on computer
  }

  @Test
  public void testArrayListAccess() {
    long sum = 0;
    for (int r = 0; r < REPS; r++) {
      sum += arrayList.get(r % DRY);
    }
    //when DRY = 10, 697 ms
    //when DRY = 100, 727ms
    //when DRY = 1000, 848 ms
    //when DRY = 100000, 1 s 852ms
    //when DRY = 10000000,
  }
}
