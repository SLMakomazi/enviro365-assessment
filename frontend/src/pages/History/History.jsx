import './History.css';

const historyItems = [
  { id: 'h1', title: 'Monthly earnings update', date: '2026-05-30' },
  { id: 'h2', title: 'Withdrawal request approved', date: '2026-06-01' },
  { id: 'h3', title: 'Account summary generated', date: '2026-06-04' },
];

function History() {
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
