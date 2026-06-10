import { useState, useEffect } from 'react';
import { fetchWithdrawals, submitWithdrawal } from '../../services/apiService';
import WithdrawalForm from '../../components/WithdrawalForm/WithdrawalForm';
import WithdrawalTable from '../../components/WithdrawalTable/WithdrawalTable';
import './Withdrawals.css';

function Withdrawals() {
  const [withdrawals, setWithdrawals] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const loadWithdrawals = async () => {
      try {
        const data = await fetchWithdrawals();
        const formattedData = data.map((item) => ({
          id: item.id,
          date: item.requestedAt ? item.requestedAt.split('T')[0] : new Date().toISOString().slice(0, 10),
          amount: `$${item.amount.toFixed(2)}`,
          status: item.status,
        }));
        setWithdrawals(formattedData);
      } catch (error) {
        console.error('Failed to fetch withdrawals:', error);
      } finally {
        setLoading(false);
      }
    };

    loadWithdrawals();
  }, []);

  const handleSubmit = async (payload) => {
    try {
      const response = await submitWithdrawal(payload);
      const newWithdrawal = {
        id: response.id,
        date: response.requestedAt ? response.requestedAt.split('T')[0] : new Date().toISOString().slice(0, 10),
        amount: `$${response.amount.toFixed(2)}`,
        status: response.status,
      };
      setWithdrawals((current) => [newWithdrawal, ...current]);
    } catch (error) {
      console.error('Failed to submit withdrawal:', error);
      alert('Failed to submit withdrawal. Please try again.');
    }
  };

  if (loading) {
    return (
      <section className="withdrawals-page section-card">
        <div className="withdrawals-grid">
          <div>Loading...</div>
        </div>
      </section>
    );
  }

  return (
    <section className="withdrawals-page section-card">
      <div className="withdrawals-grid">
        <WithdrawalForm onSubmit={handleSubmit} />
        <WithdrawalTable withdrawals={withdrawals} />
      </div>
    </section>
  );
}

export default Withdrawals;
