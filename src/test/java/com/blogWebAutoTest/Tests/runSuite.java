package com.blogWebAutoTest.Tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({blogLoginTest.class, blogListTest.class, blogEditTest.class})
public class runSuite {

}
