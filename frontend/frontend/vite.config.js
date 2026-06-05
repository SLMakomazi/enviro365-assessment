// Vite build/dev-server configuration for the React app.

// Import Vite's config helper for typed, validated configuration.
import { defineConfig } from 'vite' // defineConfig: config with type hints
// Import the official React plugin (Fast Refresh, JSX transform).
import react from '@vitejs/plugin-react' // Enables React + HMR support

// https://vite.dev/config/
// Export the resolved configuration object consumed by Vite.
export default defineConfig({
  plugins: [react()], // Register the React plugin
})
