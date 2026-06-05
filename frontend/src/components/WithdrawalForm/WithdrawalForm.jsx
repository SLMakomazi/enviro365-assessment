import { useState } from 'react';
import './WithdrawalForm.css';
import { isRequired, isValidAmount } from '../../utils/validators';

function WithdrawalForm({ onSubmit }) {
  const [amount, setAmount] = useState('');
  const [reason, setReason] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();
    if (!isValidAmount(amount)) {
      setError('Enter a valid amount greater than zero.');
      return;
    }
    if (!isRequired(reason)) {
      setError('Provide a reason for the withdrawal.');
      return;
    }
    setError('');
    onSubmit({ amount: Number(amount), reason });
    setAmount('');
    setReason('');
  };

  return (
    <form className="withdrawal-form" onSubmit={handleSubmit}>
      <h2>Request Withdrawal</h2>
      <label>
        Amount
        <input
          type="number"
          value={amount}
          onChange={(event) => setAmount(event.target.value)}
          min="0"
          placeholder="Enter amount"
        />
      </label>
      <label>
        Reason
        <textarea
          value={reason}
          onChange={(event) => setReason(event.target.value)}
          placeholder="Enter a brief reason"
        />
      </label>
      {error && <div className="form-error">{error}</div>}
      <button type="submit">Submit Withdrawal</button>
    </form>
  );
}

export default WithdrawalForm;
