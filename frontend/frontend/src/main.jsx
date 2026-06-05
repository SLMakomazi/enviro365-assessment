// Application entry point: bootstraps the React app into the DOM.

// Import React's StrictMode wrapper for highlighting potential problems.
import { StrictMode } from 'react' // StrictMode: dev-only checks and warnings
// Import createRoot, the React 18+ concurrent rendering API.
import { createRoot } from 'react-dom/client' // createRoot: mounts the app
// Import global stylesheet so it is bundled and applied app-wide.
import './index.css' // Global base styles
// Import the root App component that holds the UI tree.
import App from './App.jsx' // Root component

// Find the #root element from index.html, create a React root, and render the app.
createRoot(document.getElementById('root')).render( // Mount onto <div id="root">
  <StrictMode>
    {/* App is the top-level component rendered inside StrictMode */}
    <App />
  </StrictMode>,
)
