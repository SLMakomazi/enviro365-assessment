import './PortfolioCard.css';

function PortfolioCard({ title, value, description }) {
  return (
    <div className="portfolio-card">
      <div className="portfolio-card-header">
        <h3>{title}</h3>
        <p>{value}</p>
      </div>
      <p className="portfolio-card-description">{description}</p>
    </div>
  );
}

export default PortfolioCard;
