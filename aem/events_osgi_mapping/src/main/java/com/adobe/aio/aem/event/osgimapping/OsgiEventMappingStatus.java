/*
 * Copyright 2017 Adobe. All rights reserved.
 * This file is licensed to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
 * OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.adobe.aio.aem.event.osgimapping;

import com.adobe.aio.event.management.model.EventMetadata;

public class OsgiEventMappingStatus {

  private final EventMetadata configuredEventMetadata;
  private final EventMetadata registeredEventMetadata;
  private final Throwable error;

  public OsgiEventMappingStatus(final OsgiEventMappingSupplier eventMetadataSupplier) {
    configuredEventMetadata = eventMetadataSupplier.getConfiguredEventMetadata();
    registeredEventMetadata = eventMetadataSupplier.getRegisteredEventMetadata();
    error = eventMetadataSupplier.getError();
  }

  public EventMetadata getConfiguredEventMetadata() {
    return configuredEventMetadata;
  }

  public boolean isUp() {
    return (error == null && configuredEventMetadata != null && registeredEventMetadata != null);
  }

  public EventMetadata getRegisteredEventMetadata() {
    return registeredEventMetadata;
  }

  public String getError() {
    if (error != null) {
      return error.getClass().getSimpleName() + ":" + error.getMessage();
    } else {
      return null;
    }
  }


}
