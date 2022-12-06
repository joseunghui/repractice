import React from 'react';
import ReactDOM, {createRoot} from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import { Provider } from 'react-redux';
import { createStore } from 'redux';
import './index.css';
import App from './shared/App';
import { composeWithDevTools } from 'redux-devtools-extension';
import rootReducer from './modules/index';
import reportWebVitals from './reportWebVitals';

const store = createStore(rootReducer, composeWithDevTools());

const container = document.getElementById('root');
const root = createRoot(container);
root.render(
    <Provider store={store}>
        <BrowserRouter>
            <App />
        </BrowserRouter>
    </Provider>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
