import React, {Component} from 'react';
import {MapTo} from '@adobe/aem-react-editable-components';

export const FeatureEditConfig = {

    emptyLabel: 'Feature',

    isEmpty: function(props) {
        return !props || !props.label;
    }
};

export default class Feature extends Component {

    get content() {
        return <h2 className="feature-heading">{this.props.label}</h2>;
    }

    render() {
        if(FeatureEditConfig.isEmpty(this.props)) {
            return null;
        }

        return (
                <div className="feature">
                    {this.content}
                </div>
        );
    }
}

MapTo('aem-spa-demo/components/feature')(Feature, FeatureEditConfig);