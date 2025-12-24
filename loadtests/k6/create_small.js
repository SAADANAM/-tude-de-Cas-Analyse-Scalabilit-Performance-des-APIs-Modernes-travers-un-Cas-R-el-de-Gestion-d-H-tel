
import http from 'k6/http';
import { check } from 'k6';

// Configuration for the load test
export let options = {
  vus: __ENV.VUS ? Number(__ENV.VUS) : 100,
  duration: '30s',
};

const reservationPayload = JSON.stringify({
  client: { nom: "anam", prenom: "saad", email: "j@d.com" },
  chambre: { id: 1 },
  dateDebut: "2026-02-01",
  dateFin: "2026-02-05",
  preferences: "none"
});

export default function () {
  const response = http.post('http://localhost:8080/reservations', reservationPayload, { headers: { 'Content-Type': 'application/json' } });
  check(response, { 'created': (r) => r.status === 201 });
}
