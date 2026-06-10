import { useState, useEffect } from 'react';
import { fetchHistory } from '../../services/apiService';
import './History.css';

function History() {
  const [historyItems, setHistoryItems] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const loadHistory = async () => {
      try {
        const data = await fetchHistory();
        const formattedData = data.map((item) => ({
          id: item.id,
          title: item.title || item.reason || 'Transaction',
          date: item.date || item.requestedAt?.split('T')[0] || new Date().toISOString().slice(0, 10),
        }));
        setHistoryItems(formattedData);
      } catch (error) {
        console.error('Failed to fetch history:', error);
      } finally {
        setLoading(false);
      }
    };

    loadHistory();
  }, []);

  if (loading) {
    return (
      <section className="history-page section-card">
        <h1 className="history-title">History</h1>
        <p className="history-description">Loading...</p>
      </section>
    );
  }

  return (
    <section className="history-page section-card">
      <h1 className="history-title">History</h1>
      <p className="history-description">Recent account activity and important updates.</p>
      <ul className="history-list">
        {historyItems.map((item) => (
          <li key={item.id} className="history-item">
            <span>{item.title}</span>
            <span>{item.date}</span>
          </li>
        ))}
      </ul>
    </section>
  );
}

export default History;
