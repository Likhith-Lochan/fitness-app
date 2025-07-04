
import ReactDOM from 'react-dom/client'
import { Provider } from 'react-redux'
import {store} from './store/store.js'
import { AuthProvider } from 'react-oauth2-code-pkce'
import { authConfig } from './authConfig.js'
import App from './App'

// As of React 18
const root = ReactDOM.createRoot(document.getElementById('root'))
root.render(
  <AuthProvider authConfig={authConfig} loadingComponent={<div>Loading ....</div>}>
     <Provider store={store}>
        <App />
     </Provider>
  </AuthProvider>,
)