import { Page, withModel } from '@adobe/aem-react-editable-components';
import React from 'react';
import Header from './components/Header/Header';
import Footer from './components/Footer/Footer';

// This component is the application entry point
class App extends Page {
  render() {
    return (
      <div>
        <Header />
        {this.childComponents}
        {this.childPages}
        <Footer />
      </div>
    );
  }
}

export default withModel(App);
