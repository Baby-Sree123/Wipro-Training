import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllUserAccounts } from './all-user-accounts';

describe('AllUserAccounts', () => {
  let component: AllUserAccounts;
  let fixture: ComponentFixture<AllUserAccounts>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllUserAccounts]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllUserAccounts);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
