import { CanActivateFn, Router } from '@angular/router';
import { inject } from '@angular/core';
import { AuthService } from './auth.service';

export const authGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);

console.log('AuthGuard check, token:', authService.getToken());

  if (authService.isLoggedIn()) {
    return true; // allow access
  } else {
    router.navigate(['/login']);
    return false;
  }
};
