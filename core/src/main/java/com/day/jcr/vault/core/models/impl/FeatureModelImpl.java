package com.day.jcr.vault.core.models.impl;

import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import com.day.jcr.vault.core.models.FeatureModel;

// Sling Model annotation
@Model(
    adaptables = SlingHttpServletRequest.class,
    adapters = { FeatureModel.class, ComponentExporter.class },
    resourceType = FeatureModelImpl.RESOURCE_TYPE,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
    )
@Exporter( //Exporter annotation that serializes the modoel as JSON
    name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
    extensions = ExporterConstants.SLING_MODEL_EXTENSION
    )
public class FeatureModelImpl implements FeatureModel {

    @ValueMapValue
    private String label; //maps variable to jcr property named "label" persisted by Dialog

    // points to AEM component definition in ui.apps
    static final String RESOURCE_TYPE = "aem-spa-demo/components/feature";

    // public getter method to expose value of private variable `label`
    // adds additional logic to default the label to "(Default)" if not set.
    @Override
    public String getLabel() {
        return StringUtils.isNotBlank(label) ? label : "(Default)";
    }

    // method required by `ComponentExporter` interface
    // exposes a JSON property named `:type` with a value of `wknd-spa-react/components/open-weather`
    // required to map the JSON export to the SPA component props via the `MapTo`
    @Override
    public String getExportedType() {
        return FeatureModelImpl.RESOURCE_TYPE;
    }
}