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
}
