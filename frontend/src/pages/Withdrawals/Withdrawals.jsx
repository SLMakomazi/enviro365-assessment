import { useState } from 'react';
import WithdrawalForm from '../../components/WithdrawalForm/WithdrawalForm';
import WithdrawalTable from '../../components/WithdrawalTable/WithdrawalTable';
import './Withdrawals.css';

const initialWithdrawals = [
  { id: '1', date: '2026-05-12', amount: '$1,450', status: 'Completed' },
  { id: '2', date: '2026-06-01', amount: '$2,560', status: 'Pending' },
];

function Withdrawals() {
  const [withdrawals, setWithdrawals] = useState(initialWithdrawals);

  const handleSubmit = (payload) => {
    setWithdrawals((current) => [
      { id: String(current.length + 1), date: new Date().toISOString().slice(0, 10), amount: `$${payload.amount}`, status: 'Pending' },
      ...current,
    ]);
  };

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
