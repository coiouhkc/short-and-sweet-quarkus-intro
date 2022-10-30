package org.abratuhi.quarkus;

import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.List;

public class SftpTestProfile implements QuarkusTestProfile {
  @Override
  public List<TestResourceEntry> testResources() {
    return List.of(new TestResourceEntry(SftpTestResource.class));
  }
}
