import './WithdrawalTable.css';

function WithdrawalTable({ withdrawals }) {
  return (
    <div className="withdrawal-table-card">
      <h2>Recent Withdrawals</h2>
      <table className="withdrawal-table">
        <thead>
          <tr>
            <th>Date</th>
            <th>Amount</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {withdrawals.map((item) => (
            <tr key={item.id}>
              <td>{item.date}</td>
              <td>{item.amount}</td>
              <td>{item.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default WithdrawalTable;
