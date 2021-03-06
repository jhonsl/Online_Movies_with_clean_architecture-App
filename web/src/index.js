import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import configureStore from './store/store'
import { Provider } from 'react-redux'
import App from './App';

const store = configureStore();

ReactDOM.render(
  <React.StrictMode>
    <Provider store={store}>
      <App />
    </Provider>
  </React.StrictMode>,
  document.getElementById('root')
);
