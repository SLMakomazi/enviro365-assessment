import { useMemo } from 'react';
import PortfolioCard from '../../components/PortfolioCard/PortfolioCard';
import './Dashboard.css';

function Dashboard() {
  const portfolioData = useMemo(
    () => [
      { title: 'Available Balance', value: '$14,860', description: 'Money ready for withdrawal or investment.' },
      { title: 'Pending Withdrawals', value: '$2,560', description: 'Withdrawals currently being processed.' },
      { title: 'Total Portfolio', value: '$98,420', description: 'Total account value across all funded programs.' },
    ],
    []
  );

  return (
    <section className="dashboard-page section-card">
      <div className="dashboard-hero">
        <div>
          <h1 className="dashboard-title">Welcome back</h1>
          <p className="dashboard-subtitle">Monitor your account activity and track withdrawals from one place.</p>
        </div>
      </div>
      <div className="portfolio-grid">
        {portfolioData.map((item) => (
          <PortfolioCard key={item.title} {...item} />
        ))}
      </div>
    </section>
  );
}

export default Dashboard;
