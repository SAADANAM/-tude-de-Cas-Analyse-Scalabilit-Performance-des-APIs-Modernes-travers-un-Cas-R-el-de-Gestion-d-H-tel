
from locust import HttpUser, task, between

class HotelUser(HttpUser):
    """
    Simulates a hotel user for load testing.
    """
    wait_time = between(1, 2)

    @task(3)
    def make_reservation(self):
        """
        Task to create a new reservation.
        """
        reservation_payload = {
            "client": {"nom": "anam", "prenom": "saad"},
            "chambre": {"id": 1},
            "dateDebut": "2026-02-01",
            "dateFin": "2026-02-05",
            "preferences": "none"
        }
        self.client.post("/reservations", json=reservation_payload)
