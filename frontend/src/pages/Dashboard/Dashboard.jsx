import { useState, useEffect } from 'react';
import { fetchPortfolio } from '../../services/apiService';
import PortfolioCard from '../../components/PortfolioCard/PortfolioCard';
import './Dashboard.css';

function Dashboard() {
  const [portfolioData, setPortfolioData] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const loadPortfolio = async () => {
      try {
        const data = await fetchPortfolio();
        const formattedData = [
          { title: 'Available Balance', value: `$${data.availableBalance?.toFixed(2) || '0.00'}`, description: 'Money ready for withdrawal or investment.' },
          { title: 'Pending Withdrawals', value: `$${data.pendingWithdrawals?.toFixed(2) || '0.00'}`, description: 'Withdrawals currently being processed.' },
          { title: 'Total Portfolio', value: `$${data.totalPortfolio?.toFixed(2) || '0.00'}`, description: 'Total account value across all funded programs.' },
        ];
        setPortfolioData(formattedData);
      } catch (error) {
        console.error('Failed to fetch portfolio data:', error);
        setPortfolioData([
          { title: 'Available Balance', value: '$0.00', description: 'Money ready for withdrawal or investment.' },
          { title: 'Pending Withdrawals', value: '$0.00', description: 'Withdrawals currently being processed.' },
          { title: 'Total Portfolio', value: '$0.00', description: 'Total account value across all funded programs.' },
        ]);
      } finally {
        setLoading(false);
      }
    };

    loadPortfolio();
  }, []);

  if (loading) {
    return (
      <section className="dashboard-page section-card">
        <div className="dashboard-hero">
          <div>
            <h1 className="dashboard-title">Loading...</h1>
          </div>
        </div>
      </section>
    );
  }

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
