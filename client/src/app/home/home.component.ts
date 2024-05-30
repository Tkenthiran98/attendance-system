import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  username: string | null = '';

  constructor(public authService: AuthService) { }

  ngOnInit(): void {
    this.updateUsername();
  }

  updateUsername(): void {
    this.username = this.authService.getUsername();
  }

  logout(): void {
    this.authService.logout();
    this.username = null; // Clear username after logout
  }

  markAttendance(): void {
    // Implement your mark attendance logic here
    alert('Attendance marked successfully!');
  }

  viewAttendance(): void {
    // Implement your view attendance logic here
    alert('Viewing attendance...');
  }
}
