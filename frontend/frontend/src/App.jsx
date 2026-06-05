// App.jsx: the root UI component rendering the landing page layout.

// Import the useState hook to manage local component state.
import { useState } from 'react' // useState: track the click counter
// Import asset URLs that Vite resolves to bundled paths.
import reactLogo from './assets/react.svg' // React logo image
import viteLogo from './assets/vite.svg' // Vite logo image
import heroImg from './assets/hero.png' // Hero background image
// Import component-scoped styles for this view.
import './App.css' // Styles for the App layout

// App: top-level functional component that builds the page.
function App() {
  // count holds the number of button clicks; setCount updates it.
  const [count, setCount] = useState(0) // Counter state, starts at 0

  // Render the page: hero section, counter button, and "next steps" links.
  return (
    <>
      {/* Hero section: centered logos, heading, and the counter button */}
      <section id="center">
        {/* Stacked logos forming the hero artwork */}
        <div className="hero">
          <img src={heroImg} className="base" width="170" height="179" alt="" />
          <img src={reactLogo} className="framework" alt="React logo" />
          <img src={viteLogo} className="vite" alt="Vite logo" />
        </div>
        {/* Intro copy prompting the user to edit the source */}
        <div>
          <h1>Get started</h1>
          <p>
            Edit <code>src/App.jsx</code> and save to test <code>HMR</code>
          </p>
        </div>
        {/* Counter button: increments count on each click */}
        <button
          type="button"
          className="counter"
          onClick={() => setCount((count) => count + 1)} // Increment counter
        >
          Count is {count}
        </button>
      </section>

      {/* Decorative divider */}
      <div className="ticks"></div>

      {/* Next steps section: documentation and social links */}
      <section id="next-steps">
        {/* Documentation column */}
        <div id="docs">
          <svg className="icon" role="presentation" aria-hidden="true">
            <use href="/icons.svg#documentation-icon"></use>
          </svg>
          <h2>Documentation</h2>
          <p>Your questions, answered</p>
          {/* External documentation links */}
          <ul>
            <li>
              <a href="https://vite.dev/" target="_blank">
                <img className="logo" src={viteLogo} alt="" />
                Explore Vite
              </a>
            </li>
            <li>
              <a href="https://react.dev/" target="_blank">
                <img className="button-icon" src={reactLogo} alt="" />
                Learn more
              </a>
            </li>
          </ul>
        </div>
        {/* Social column */}
        <div id="social">
          <svg className="icon" role="presentation" aria-hidden="true">
            <use href="/icons.svg#social-icon"></use>
          </svg>
          <h2>Connect with us</h2>
          <p>Join the Vite community</p>
          {/* External community/social links */}
          <ul>
            <li>
              <a href="https://github.com/vitejs/vite" target="_blank">
                <svg
                  className="button-icon"
                  role="presentation"
                  aria-hidden="true"
                >
                  <use href="/icons.svg#github-icon"></use>
                </svg>
                GitHub
              </a>
            </li>
            <li>
              <a href="https://chat.vite.dev/" target="_blank">
                <svg
                  className="button-icon"
                  role="presentation"
                  aria-hidden="true"
                >
                  <use href="/icons.svg#discord-icon"></use>
                </svg>
                Discord
              </a>
            </li>
            <li>
              <a href="https://x.com/vite_js" target="_blank">
                <svg
                  className="button-icon"
                  role="presentation"
                  aria-hidden="true"
                >
                  <use href="/icons.svg#x-icon"></use>
                </svg>
                X.com
              </a>
            </li>
            <li>
              <a href="https://bsky.app/profile/vite.dev" target="_blank">
                <svg
                  className="button-icon"
                  role="presentation"
                  aria-hidden="true"
                >
                  <use href="/icons.svg#bluesky-icon"></use>
                </svg>
                Bluesky
              </a>
            </li>
          </ul>
        </div>
      </section>

      {/* Decorative divider */}
      <div className="ticks"></div>
      {/* Bottom spacer section */}
      <section id="spacer"></section>
    </>
  )
}

// Export App as the default export so main.jsx can import it.
export default App // Default export: the root component
