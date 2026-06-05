// ESLint flat configuration for linting the frontend source.

// Core ESLint recommended JS rules.
import js from '@eslint/js' // Base recommended JavaScript ruleset
// Predefined sets of global variables (e.g. browser globals).
import globals from 'globals' // Provides known global identifiers
// React Hooks linting rules (rules-of-hooks, exhaustive-deps).
import reactHooks from 'eslint-plugin-react-hooks' // Hook usage rules
// React Fast Refresh constraints for Vite.
import reactRefresh from 'eslint-plugin-react-refresh' // Fast Refresh rules
// Helpers to build and ignore paths in the flat config.
import { defineConfig, globalIgnores } from 'eslint/config' // Config helpers

// Export the array of flat config blocks ESLint will apply.
export default defineConfig([
  globalIgnores(['dist']), // Skip linting the build output directory
  {
    files: ['**/*.{js,jsx}'], // Apply this block to JS and JSX files
    extends: [
      js.configs.recommended, // Recommended core JS rules
      reactHooks.configs.flat.recommended, // Recommended React Hooks rules
      reactRefresh.configs.vite, // Fast Refresh rules tuned for Vite
    ],
    languageOptions: {
      globals: globals.browser, // Treat browser globals as defined
      parserOptions: { ecmaFeatures: { jsx: true } }, // Enable JSX parsing
    },
  },
])
