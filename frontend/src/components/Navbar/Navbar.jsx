import './Navbar.css';

const navItems = ['Dashboard', 'Withdrawals', 'History'];

function Navbar({ activePage, onNavigate }) {
  return (
    <header className="navbar-shell">
      <div className="navbar-brand">Enviro365</div>
      <nav className="navbar-links">
        {navItems.map((item) => (
          <button
            key={item}
            className={item === activePage ? 'navbar-link active' : 'navbar-link'}
            type="button"
            onClick={() => onNavigate(item)}
          >
            {item}
          </button>
        ))}
      </nav>
    </header>
  );
}

export default Navbar;
