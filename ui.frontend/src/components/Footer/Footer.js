//Footer.js
import React, {Component} from 'react';
import {Link} from 'react-router-dom';
require('./Footer.css');

export default class Footer extends Component {

    render() {
        return (
                <footer className="Footer">
                    <div className="Footer-container">
                        <Link to="/content/aem-spa-demo/us/en/home.html">
                            <h3>Footer</h3>
                        </Link>
                    </div>
                </footer>
        );
    }
}