import { useState } from 'react';
import './index.css';
import Navbar from './components/Navbar/Navbar';
import Dashboard from './pages/Dashboard/Dashboard';
import Withdrawals from './pages/Withdrawals/Withdrawals';
import History from './pages/History/History';

function App() {
  const [activePage, setActivePage] = useState('Dashboard');

  return (
    <div className="app-shell">
      <Navbar activePage={activePage} onNavigate={setActivePage} />
      <main className="page-container">
        {activePage === 'Dashboard' && <Dashboard />}
        {activePage === 'Withdrawals' && <Withdrawals />}
        {activePage === 'History' && <History />}
      </main>
    </div>
  );
}

export default App;
