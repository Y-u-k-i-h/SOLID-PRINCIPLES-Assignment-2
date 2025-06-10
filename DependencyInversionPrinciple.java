public class DependencyInversionPrinciple {
    
    // BAD EXAMPLE - Violates DIP
    static class BadEmailNotification {
        public void send(String message) {
            System.out.println("Sending email: " + message);
        }
    }
    
    static class BadNotificationService {
        private BadEmailNotification emailNotification; // Direct dependency on concrete class
        
        public BadNotificationService() {
            this.emailNotification = new BadEmailNotification(); // Tight coupling - VIOLATION
        }
        
        public void notify(String message) {
            emailNotification.send(message);
            // Hard to extend to SMS, Push notifications etc.
        }
    }
    
    // GOOD EXAMPLE - Follows DIP
    interface NotificationSender {
        void send(String message);
    }
    
    static class EmailNotification implements NotificationSender {
        @Override
        public void send(String message) {
            System.out.println("Sending email: " + message);
        }
    }
    
    static class SMSNotification implements NotificationSender {
        @Override
        public void send(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }
    
    static class PushNotification implements NotificationSender {
        @Override
        public void send(String message) {
            System.out.println("Sending push notification: " + message);
        }
    }
    
    static class NotificationService {
        private NotificationSender notificationSender; // Depends on abstraction
        
        public NotificationService(NotificationSender notificationSender) {
            this.notificationSender = notificationSender; // Dependency injection
        }
        
        public void notify(String message) {
            notificationSender.send(message);
        }
    }

    // Demonstration method
    public static void demonstrateDIP() {
        System.out.println("=== DIP Demonstration ===");
        
        // Good example - using dependency injection
        NotificationSender emailSender = new EmailNotification();
        NotificationService emailService = new NotificationService(emailSender);
        emailService.notify("Hello via Email!");
        
        // Easy to switch to different notification types
        NotificationSender smsSender = new SMSNotification();
        NotificationService smsService = new NotificationService(smsSender);
        smsService.notify("Hello via SMS!");
        
        NotificationSender pushSender = new PushNotification();
        NotificationService pushService = new NotificationService(pushSender);
        pushService.notify("Hello via Push!");
        
        System.out.println("\n=== Bad Example (Tight Coupling) ===");
        // Bad example - tightly coupled to email only
        BadNotificationService badService = new BadNotificationService();
        badService.notify("This can only be sent via email");
        // No way to change notification type without modifying the class
    }
    
    public static void main(String[] args) {
        demonstrateDIP();
    }
}
