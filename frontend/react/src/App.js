import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [reservationData, setReservationData] = useState(null);

  async function createNewReservation() {
    const data = {
      client: { nom: 'anam', prenom: 'saad' },
      chambre: { id: 1 },
      dateDebut: '2026-02-01',
      dateFin: '2026-02-05',
      preferences: 'none'
    };

    const response = await axios.post('http://localhost:8080/reservations', data);
    setReservationData(response.data);
  }

  return (
    <div style={{ padding: 20 }}>
      <h3>Hotel API Test</h3>
      <button onClick={createNewReservation}>Create reservation</button>
      <pre>{JSON.stringify(reservationData, null, 2)}</pre>
    </div>
  );
}

export default App;
