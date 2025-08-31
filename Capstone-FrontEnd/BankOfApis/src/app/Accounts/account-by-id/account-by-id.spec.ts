import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountById } from './account-by-id';

describe('AccountById', () => {
  let component: AccountById;
  let fixture: ComponentFixture<AccountById>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AccountById]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AccountById);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
