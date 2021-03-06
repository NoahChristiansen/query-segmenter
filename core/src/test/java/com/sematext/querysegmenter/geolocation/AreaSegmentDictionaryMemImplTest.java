/*
 *    Copyright (c) Sematext International
 *    All Rights Reserved
 *
 *    THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Sematext International
 *    The copyright notice above does not evidence any
 *    actual or intended publication of such source code.
 */
package com.sematext.querysegmenter.geolocation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AreaSegmentDictionaryMemImplTest {

  private AreaSegmentDictionaryMemImpl dictionary;
  private String filename = "src/test/resources/neighborhood.txt";

  @Before
  public void setup() {
    dictionary = new AreaSegmentDictionaryMemImpl();
  }

  @Test
  public void test_lookup() throws Exception {
    dictionary.load(filename);

    String segment = "Eagle River Valley";
    List<AreaTypedSegment> list = dictionary.lookup(segment);
    assertEquals(1, list.size());
    AreaTypedSegment area = list.get(0);
    // For this test, the segment is the same as the label
    assertEquals(segment, area.getLabel());
  }

  @Test
  public void test_lookup_case_insensitive() throws Exception {
    dictionary.load(filename);

    String segment = "Eagle River Valley";
    List<AreaTypedSegment> list = dictionary.lookup(segment.toLowerCase());
    assertEquals(1, list.size());
    AreaTypedSegment area = list.get(0);
    // For this test, the segment is the same as the label
    assertEquals(segment, area.getLabel());
  }

}
